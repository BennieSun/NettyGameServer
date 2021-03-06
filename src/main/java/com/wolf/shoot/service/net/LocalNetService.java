package com.wolf.shoot.service.net;

import com.wolf.shoot.common.config.GameServerConfig;
import com.wolf.shoot.common.config.GameServerConfigService;
import com.wolf.shoot.common.constant.GlobalConstants;
import com.wolf.shoot.common.constant.ServiceName;
import com.wolf.shoot.manager.LocalMananger;
import com.wolf.shoot.service.IService;

/**
 * Created by jiangwenping on 17/2/15.
 */
public class LocalNetService implements IService{

    private GameNettyTcpServerService gameNettyTcpServerService;
    private GameNettyUdpServerService gameNettyUdpServerService;

    @Override
    public String getId() {
        return ServiceName.LocalNetService;
    }

    @Override
    public void startup() throws Exception {
        GameServerConfigService gameServerConfigService = LocalMananger.getInstance().getGameServerConfigService();
        GameServerConfig gameServerConfig = gameServerConfigService.getGameServerConfig();
        gameNettyTcpServerService = new GameNettyTcpServerService(gameServerConfig.getServerId(), gameServerConfig.getPort()
                , GlobalConstants.Thread.NET_TCP_BOSS, GlobalConstants.Thread.NET_TCP_WORKER);
        gameNettyTcpServerService.startService();

        gameNettyUdpServerService = new GameNettyUdpServerService(gameServerConfig.getServerId(),gameServerConfig.getUdpPort()
                , GlobalConstants.Thread.NET_UDP_WORKER);
        gameNettyUdpServerService.startService();
    }

    @Override
    public void shutdown() throws Exception {
        if(gameNettyTcpServerService != null){
            gameNettyTcpServerService.stopService();
        }

        if(gameNettyUdpServerService != null){
            gameNettyUdpServerService.stopService();
        }
    }
}
