package com.ning.http.client.providers.netty.handler;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.codec.http.HttpChunk;
import org.jboss.netty.handler.codec.http.HttpMessage;

import com.ning.http.client.providers.netty.channel.Channels;
import com.ning.http.client.providers.netty.future.NettyResponseFuture;
/**
 * Count for input response body size
 * @author caoliuyi
 *
 */
public class InputTrafficCountHandler extends SimpleChannelUpstreamHandler {
    
    public void messageReceived(
            ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        Object msg = e.getMessage();
        int size = 0;
        if (msg instanceof HttpMessage) {
            size = HttpMessage.class.cast(msg).getContent().readableBytes();
        } else if (msg instanceof HttpChunk) {
            size = HttpChunk.class.cast(msg).getContent().readableBytes();
        }
        Object att = Channels.getAttribute(ctx.getChannel());
        if (att != null && att instanceof NettyResponseFuture) {
            NettyResponseFuture.class.cast(att).getAndSetRawBodyPartSize(size);
        }
        ctx.sendUpstream(e);
    }
}
