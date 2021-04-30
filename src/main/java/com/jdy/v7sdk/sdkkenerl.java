// This file is auto-generated, don't edit it. Thanks.
package com.jdy.v7sdk;

import com.aliyun.tea.*;
import com.jdy.v7sdk.models.*;
import com.aliyun.teautil.*;

public class sdkkenerl {

    public String _server_host;
    public String _protocol;
    /**
     * init the client
     * @param config Config of the config
     */
    public sdkkenerl(Config config) throws Exception {
        this._server_host = config.host;
        this._protocol = config.protocol;
    }

    public java.util.Map<String, ?> _get(String pathname, TeaModel headers, TeaModel query) throws Exception {
        TeaModel.validateParams(headers, "headers");
        TeaModel.validateParams(query, "query");
        java.util.Map<String, Object> runtime_ = TeaConverter.buildMap(
            new TeaPair("connectTimeout", 15000),
            new TeaPair("readTimeout", 15000),
            new TeaPair("retry", TeaConverter.buildMap(
                new TeaPair("maxAttempts", 0)
            ))
        );

        TeaRequest _lastRequest = null;
        Exception _lastException = null;
        long _now = System.currentTimeMillis();
        int _retryTimes = 0;
        while (Tea.allowRetry((java.util.Map<String, Object>) runtime_.get("retry"), _retryTimes, _now)) {
            if (_retryTimes > 0) {
                int backoffTime = Tea.getBackoffTime(runtime_.get("backoff"), _retryTimes);
                if (backoffTime > 0) {
                    Tea.sleep(backoffTime);
                }
            }
            _retryTimes = _retryTimes + 1;
            try {
                TeaRequest request_ = new TeaRequest();
                request_.method = "GET";
                request_.protocol = _protocol;
                request_.pathname = pathname;
                request_.headers = TeaConverter.buildMap(
                    new TeaPair("host", _server_host)
                );
                java.util.Map<String, String> headersMap = com.aliyun.teautil.Common.stringifyMapValue(TeaModel.buildMap(query));
                if (!com.aliyun.teautil.Common.empty(headersMap.get("accountId"))) {
                    request_.headers.put("accountId", headersMap.get("accountId"));
                }

                if (!com.aliyun.teautil.Common.empty(headersMap.get("groupName"))) {
                    request_.headers.put("groupName", headersMap.get("groupName"));
                }

                request_.query = com.aliyun.teautil.Common.stringifyMapValue(TeaModel.buildMap(query));
                _lastRequest = request_;
                TeaResponse response_ = Tea.doAction(request_, runtime_);

                return this._handle(response_);
            } catch (Exception e) {
                if (Tea.isRetryable(e)) {
                    _lastException = e;
                    continue;
                }
                throw e;
            }
        }

        throw new TeaUnretryableException(_lastRequest, _lastException);
    }

    public java.util.Map<String, ?> _post(String pathname, TeaModel headers, TeaModel query, TeaModel body) throws Exception {
        TeaModel.validateParams(headers, "headers");
        TeaModel.validateParams(query, "query");
        TeaModel.validateParams(body, "body");
        java.util.Map<String, Object> runtime_ = TeaConverter.buildMap(
            new TeaPair("connectTimeout", 15000),
            new TeaPair("readTimeout", 15000),
            new TeaPair("retry", TeaConverter.buildMap(
                new TeaPair("maxAttempts", 0)
            ))
        );

        TeaRequest _lastRequest = null;
        Exception _lastException = null;
        long _now = System.currentTimeMillis();
        int _retryTimes = 0;
        while (Tea.allowRetry((java.util.Map<String, Object>) runtime_.get("retry"), _retryTimes, _now)) {
            if (_retryTimes > 0) {
                int backoffTime = Tea.getBackoffTime(runtime_.get("backoff"), _retryTimes);
                if (backoffTime > 0) {
                    Tea.sleep(backoffTime);
                }
            }
            _retryTimes = _retryTimes + 1;
            try {
                TeaRequest request_ = new TeaRequest();
                request_.method = "POST";
                request_.protocol = _protocol;
                request_.pathname = pathname;
                request_.headers = TeaConverter.buildMap(
                    new TeaPair("host", _server_host),
                    new TeaPair("content-type", "application/json; charset=utf-8")
                );
                java.util.Map<String, String> headersMap = com.aliyun.teautil.Common.stringifyMapValue(TeaModel.buildMap(headers));
                if (!com.aliyun.teautil.Common.empty(headersMap.get("accountId"))) {
                    request_.headers.put("accountId", headersMap.get("accountId"));
                }

                if (!com.aliyun.teautil.Common.empty(headersMap.get("groupName"))) {
                    request_.headers.put("groupName", headersMap.get("groupName"));
                }

                request_.body = Tea.toReadable(com.aliyun.teautil.Common.toJSONString(TeaModel.buildMap(body)));
                request_.query = com.aliyun.teautil.Common.stringifyMapValue(TeaModel.buildMap(query));
                _lastRequest = request_;
                TeaResponse response_ = Tea.doAction(request_, runtime_);

                return this._handle(response_);
            } catch (Exception e) {
                if (Tea.isRetryable(e)) {
                    _lastException = e;
                    continue;
                }
                throw e;
            }
        }

        throw new TeaUnretryableException(_lastRequest, _lastException);
    }

    public java.util.Map<String, ?> get(String api, TeaModel headers, TeaModel query) throws Exception {
        return this._get(api, headers, query);
    }

    public java.util.Map<String, ?> post(String api, TeaModel headers, TeaModel query, TeaModel body) throws Exception {
        return this._post(api, headers, query, body);
    }

    /**
     * the handler use to deal with the response
     * @param response from tea repository server
     * @return result result of the server
     */
    public java.util.Map<String, ?> _handle(TeaResponse response) throws Exception {
        java.util.Map<String, Object> result = com.aliyun.teautil.Common.assertAsMap(com.aliyun.teautil.Common.readAsJSON(response.body));
        if (!com.aliyun.teautil.Common.equalNumber(response.statusCode, 200)) {
            throw new TeaException(TeaConverter.buildMap(
                new TeaPair("message", "code: " + response.statusCode + ", " + result.get("code") + " reason: " + result.get("message") + ""),
                new TeaPair("code", "" + result.get("code") + "")
            ));
        }

        return result;
    }
}
