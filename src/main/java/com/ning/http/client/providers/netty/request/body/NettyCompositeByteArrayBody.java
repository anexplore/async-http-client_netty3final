/*
 * Copyright (c) 2014 AsyncHttpClient Project. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at
 *     http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.ning.http.client.providers.netty.request.body;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.util.List;

public class NettyCompositeByteArrayBody extends NettyDirectBody {

    private final byte[][] bytes;
    private final String contentType;
    private final long contentLength;

    public NettyCompositeByteArrayBody(List<byte[]> bytes) {
        this(bytes, null);
    }

    public NettyCompositeByteArrayBody(List<byte[]> bytes, String contentType) {
        this.bytes = new byte[bytes.size()][];
        bytes.toArray(this.bytes);
        this.contentType = contentType;
        long l = 0;
        for (byte[] b : bytes)
            l += b.length;
        contentLength = l;
    }

    @Override
    public long getContentLength() {
        return contentLength;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public ChannelBuffer channelBuffer() {
        return ChannelBuffers.wrappedBuffer(bytes);
    }
}
