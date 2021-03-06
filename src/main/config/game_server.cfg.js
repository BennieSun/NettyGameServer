﻿/*
 * Server基本信息
 */
config.serverType=2
config.charset="UTF-8";
config.version="0.2.0.1";
config.regionId="1";
config.serverGroupId="1";
config.serverIndex=1;
config.serverId="8001";
config.bindIp="0.0.0.0";
config.ports="7090";
config.serverName="OnLine";
config.serverHost="0.0.0.0";
config.ioProcessor=1;
config.language="zh_CN";
config.i18nDir="i18n";
config.gameId="shoot";
config.developModel= 1;
/**异步通讯接口***/
config.communicationPort=10000;
config.communicationMaxThreadPoolSize=140;
config.communicationHandlerMaxThreadPoolSize=280;
config.communicationMaxWriteIntervalTime=60*60*1000;
config.tcpMessageQueueDirectDispatch=true;
/**gameexcutor配置***/
config.gameExcutorCorePoolSize=2;
config.gameExcutorKeepAliveTime=60;
config.gameExcutorCycleTime=1000;
config.gameExcutorMinCycleTime=1000;
/**udp配置***/
config.updPorts="10090";
config.updQueueMessageProcessWorkerSize=1;


