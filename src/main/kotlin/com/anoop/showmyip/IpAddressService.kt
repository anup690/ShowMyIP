package com.anoop.showmyip

import java.net.InetAddress
import java.net.NetworkInterface
import java.net.SocketException

object IpAddressService {
    
    /**
     * Fetches the local LAN IP address.
     * Prioritizes non-loopback IPv4 addresses.
     */
    fun getLocalIpAddress(): String {
        try {
            val interfaces = NetworkInterface.getNetworkInterfaces()
            while (interfaces.hasMoreElements()) {
                val networkInterface = interfaces.nextElement()
                
                // Skip loopback and inactive interfaces
                if (networkInterface.isLoopback || !networkInterface.isUp) {
                    continue
                }
                
                val addresses = networkInterface.inetAddresses
                while (addresses.hasMoreElements()) {
                    val address = addresses.nextElement()
                    
                    // Skip loopback and link-local addresses
                    if (address.isLoopbackAddress || address.isLinkLocalAddress) {
                        continue
                    }
                    
                    // Prefer IPv4 over IPv6
                    if (address is java.net.Inet4Address) {
                        return address.hostAddress ?: "Unknown"
                    }
                }
            }
            
            // If no IPv4 found, try IPv6
            val interfacesAgain = NetworkInterface.getNetworkInterfaces()
            while (interfacesAgain.hasMoreElements()) {
                val networkInterface = interfacesAgain.nextElement()
                
                if (networkInterface.isLoopback || !networkInterface.isUp) {
                    continue
                }
                
                val addresses = networkInterface.inetAddresses
                while (addresses.hasMoreElements()) {
                    val address = addresses.nextElement()
                    
                    if (!address.isLoopbackAddress && !address.isLinkLocalAddress) {
                        return address.hostAddress ?: "Unknown"
                    }
                }
            }
            
        } catch (e: SocketException) {
            return "Error: ${e.message}"
        } catch (e: Exception) {
            return "Error: ${e.message}"
        }
        
        return "No Network"
    }
    
    /**
     * Gets the hostname of the local machine.
     */
    fun getHostname(): String {
        return try {
            InetAddress.getLocalHost().hostName ?: "Unknown"
        } catch (e: Exception) {
            "Unknown"
        }
    }
}
