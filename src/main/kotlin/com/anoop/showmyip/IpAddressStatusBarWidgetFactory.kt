package com.anoop.showmyip

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory

class IpAddressStatusBarWidgetFactory : StatusBarWidgetFactory {
    
    override fun getId(): String = IpAddressStatusBarWidget.WIDGET_ID
    
    override fun getDisplayName(): String = "Local IP Address"
    
    override fun isAvailable(project: Project): Boolean = true
    
    override fun createWidget(project: Project): StatusBarWidget {
        return IpAddressStatusBarWidget(project)
    }
    
    override fun disposeWidget(widget: StatusBarWidget) {
        widget.dispose()
    }
    
    override fun canBeEnabledOn(statusBar: StatusBar): Boolean = true
}
