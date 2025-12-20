package com.anoop.showmyip

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidget.WidgetPresentation
import com.intellij.util.Consumer
import java.awt.event.MouseEvent
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class IpAddressStatusBarWidget(private val project: Project) : StatusBarWidget {
    
    private var statusBar: StatusBar? = null
    private var lastUpdateTime: String = ""
    
    companion object {
        const val WIDGET_ID = "IpAddressStatusBarWidget"
    }
    
    override fun ID(): String = WIDGET_ID
    
    override fun install(statusBar: StatusBar) {
        this.statusBar = statusBar
        updateLastUpdateTime()
    }
    
    override fun dispose() {
        statusBar = null
    }
    
    override fun getPresentation(): WidgetPresentation {
        return object : StatusBarWidget.TextPresentation {
            
            override fun getText(): String {
                val ip = IpAddressService.getLocalIpAddress()
                return "IP: $ip"
            }
            
            override fun getTooltipText(): String {
                val hostname = IpAddressService.getHostname()
                return "Local LAN IP Address\nHostname: $hostname\nLast updated: $lastUpdateTime\nClick to refresh"
            }
            
            override fun getClickConsumer(): Consumer<MouseEvent>? {
                return Consumer { 
                    // Refresh the IP address when clicked
                    updateLastUpdateTime()
                    statusBar?.updateWidget(ID())
                }
            }
            
            override fun getAlignment(): Float = 0f
        }
    }
    
    private fun updateLastUpdateTime() {
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        lastUpdateTime = LocalDateTime.now().format(formatter)
    }
}
