package com.wolf.shoot.service.net.session.builder;

import com.wolf.shoot.service.net.session.ISession;
import com.wolf.shoot.service.net.session.NettyUdpSession;
import io.netty.channel.Channel;

/**
 * Created by jwp on 2017/2/17.
 * udp session的生成器
 */
public class NettyUdpSessionBuilder implements ISessionBuilder {
    @Override
    public ISession buildSession(Channel channel) {
        return new NettyUdpSession(channel);
    }
}
