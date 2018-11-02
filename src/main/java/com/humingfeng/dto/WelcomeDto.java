package com.humingfeng.dto;

import java.io.Serializable;
import java.util.Map;

public class WelcomeDto implements Serializable {

    /**
     * 上月平均值
     */
    String lastMonthAverageValue;

    /**
     * 本日权限认证通过率
     */
    String todayPassingRate;

    /**
     * 全部权限认证通过率
     */
    String allPassingRate;

    /**
     * 全部城市连接成功数
     */
    Map<String,Integer> citySuccessConnectionsData;

    /**
     *服务器IP地址
     */
    String IPAddress;

    /**
     * 服务器域名
     */
    String IPDomain;

    /**
     * 服务器端口
     */
    String IPPort;

    /**
     * 服务器操作系统
     */
    String operatingSystem;

    /**
     * 服务器当前时间
     */
    String currentTime;

    /**
     * 服务器上次启动到现在已运行时间
     */
    String  runtimeTime;

    /**
     * CPU 总数
     */
    String CPUCount;

    /**
     *内存
     */
    String RAM;

    /**
     *当前Session数量
     */
    String sessionCount;

    /**
     * 当前sessionID
     */
    String sessionID;

    /**
     * 当前系统用户名
     */
    String systemName;

    public WelcomeDto() {
    }

    public String getLastMonthAverageValue() {
        return lastMonthAverageValue;
    }

    public void setLastMonthAverageValue(String lastMonthAverageValue) {
        this.lastMonthAverageValue = lastMonthAverageValue;
    }

    public String getTodayPassingRate() {
        return todayPassingRate;
    }

    public void setTodayPassingRate(String todayPassingRate) {
        this.todayPassingRate = todayPassingRate;
    }

    public String getAllPassingRate() {
        return allPassingRate;
    }

    public void setAllPassingRate(String allPassingRate) {
        this.allPassingRate = allPassingRate;
    }

    public Map<String, Integer> getCitySuccessConnectionsData() {
        return citySuccessConnectionsData;
    }

    public void setCitySuccessConnectionsData(Map<String, Integer> citySuccessConnectionsData) {
        this.citySuccessConnectionsData = citySuccessConnectionsData;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getIPDomain() {
        return IPDomain;
    }

    public void setIPDomain(String IPDomain) {
        this.IPDomain = IPDomain;
    }

    public String getIPPort() {
        return IPPort;
    }

    public void setIPPort(String IPPort) {
        this.IPPort = IPPort;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getRuntimeTime() {
        return runtimeTime;
    }

    public void setRuntimeTime(String runtimeTime) {
        this.runtimeTime = runtimeTime;
    }

    public String getCPUCount() {
        return CPUCount;
    }

    public void setCPUCount(String CPUCount) {
        this.CPUCount = CPUCount;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getSessionCount() {
        return sessionCount;
    }

    public void setSessionCount(String sessionCount) {
        this.sessionCount = sessionCount;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public String toString() {
        return "WelcomeDto{" +
                "lastMonthAverageValue='" + lastMonthAverageValue + '\'' +
                ", todayPassingRate='" + todayPassingRate + '\'' +
                ", allPassingRate='" + allPassingRate + '\'' +
                ", citySuccessConnectionsData=" + citySuccessConnectionsData +
                ", IPAddress='" + IPAddress + '\'' +
                ", IPDomain='" + IPDomain + '\'' +
                ", IPPort='" + IPPort + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", currentTime='" + currentTime + '\'' +
                ", runtimeTime='" + runtimeTime + '\'' +
                ", CPUCount='" + CPUCount + '\'' +
                ", RAM='" + RAM + '\'' +
                ", sessionCount='" + sessionCount + '\'' +
                ", sessionID='" + sessionID + '\'' +
                ", systemName='" + systemName + '\'' +
                '}';
    }
}
