package com.nexmo.client;
/*
 * Copyright (c) 2011-2016 Nexmo Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import com.nexmo.client.auth.AuthCollection;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.voice.NexmoVoiceClient;
import org.apache.http.client.HttpClient;

public class NexmoClient {
    private final NexmoVoiceClient voice;
    private HttpWrapper httpWrapper;

    public NexmoClient(AuthMethod... authMethods) {
        AuthCollection authCollection = new AuthCollection();
        for (AuthMethod method : authMethods) {
            authCollection.add(method);
        }

        this.httpWrapper = new HttpWrapper(authCollection);

        this.voice = new NexmoVoiceClient(this.httpWrapper);
    }

    public void setHttpClient(HttpClient client) {
        this.httpWrapper.setHttpClient(client);
    }

    public NexmoVoiceClient getVoiceClient() {
        return this.voice;
    }
}