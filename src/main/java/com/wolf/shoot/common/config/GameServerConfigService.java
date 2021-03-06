package com.wolf.shoot.common.config;

import com.wolf.shoot.common.constant.GlobalConstants;
import com.wolf.shoot.common.constant.ServiceName;
import com.wolf.shoot.manager.LocalMananger;
import com.wolf.shoot.service.IService;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.net.URL;


public class GameServerConfigService implements IService {

    private String dynamicProperties = "dynamic_config.properties";

    private GameServerDiffConfig gameServerDiffConfig;
    private GameServerConfig gameServerConfig;
    private GameDynamicPropertiesConfig gameDynamicPropertiesConfig;
    @Override
    public String getId() {
        return ServiceName.GameServerConfigServiceString;
    }

    @Override
    public void startup() throws Exception {
        init();
    }

    public void init(){
        initConfig();
        initDiffConfig();
        initDynamicConfig();
    }

    public void initDynamicConfig(){
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource(dynamicProperties);
        GameDynamicPropertiesConfig tempA5GameDynamicPropertiesConfig = new GameDynamicPropertiesConfig();
        tempA5GameDynamicPropertiesConfig.setResource(resource);
        tempA5GameDynamicPropertiesConfig.init();
        this.gameDynamicPropertiesConfig = tempA5GameDynamicPropertiesConfig;
    }
    @Override
    public void shutdown() throws Exception {

    }

    public GameServerDiffConfig getGameServerDiffConfig() {
        return gameServerDiffConfig;
    }

    public GameServerConfig getGameServerConfig() {
        return gameServerConfig;
    }

     private void initConfig(){
         String cfgPath = GlobalConstants.ConfigFile.GAME_SERVER_CONIFG;
         ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
         URL url = classLoader.getResource(cfgPath);
         GameServerConfig  gameServerConfig = ConfigUtil.buildConfig(GameServerConfig.class, url);
         this.gameServerConfig = gameServerConfig;
         LocalMananger.getInstance().add(this.gameServerConfig, GameServerConfig.class);
    }

    private void initDiffConfig(){
        String cfgPath = GlobalConstants.ConfigFile.GAME_SERVER_DIFF_CONIFG;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(cfgPath);
        GameServerDiffConfig gameServerDiffConfig = ConfigUtil.buildConfig(GameServerDiffConfig.class, url);
        this.gameServerDiffConfig = gameServerDiffConfig;
        LocalMananger.getInstance().add(this.gameServerDiffConfig, GameServerDiffConfig.class);
    }

    public GameDynamicPropertiesConfig getGameDynamicPropertiesConfig() {
        return gameDynamicPropertiesConfig;
    }

    public void setGameDynamicPropertiesConfig(GameDynamicPropertiesConfig gameDynamicPropertiesConfig) {
        this.gameDynamicPropertiesConfig = gameDynamicPropertiesConfig;
    }
}
