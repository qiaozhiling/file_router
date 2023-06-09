package com.example.videoplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Override
    public void run(String... args) throws SocketException {
        System.out.println("application start...");
        logger.info("serve start on: " + getLocalIp());
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static String getLocalIp() throws SocketException {
        Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            Enumeration addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress ip = (InetAddress) addresses.nextElement();
                if (ip != null && ip.isSiteLocalAddress() && ip instanceof Inet4Address) {
                    String ipAddress = ip.getHostAddress();
                    if ("192.168.122.1".equals(ipAddress)) {
                        continue;
                    }
                    return ipAddress;
                }
            }
        }
        return "127.0.0.1";
    }

}