package com.thedarkside.toybank.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.thedarkside.toybank.model.IdempotencyRequest;

@Component
public class IdempotentUtils {
    
    private final RestTemplate restTemplate;
    
    public IdempotentUtils(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
    /**
     * Idempotency Service Url
     */
    @Value("${idempotency.service.url:}")
    String idempotencyServiceUrl;

    /**
     * @param idempotencyKey
     * @param responseToCache
     */
    public void saveCache(String idempotencyKey, String responseToCache) {
        saveCache(idempotencyKey, "", "", "", "", responseToCache);
    }

    /**
     * @param idempotentKey
     * @param requestToCache
     * @param responseToCache
     */
    public void saveCache(String idempotencyKey, String requestToCache, String responseToCache) {
        saveCache(idempotencyKey, "", "", "", requestToCache, responseToCache);
    }

    /**
     * @param idempotentKey
     * @param urlPath
     * @param requestToCache
     * @param responseToCache
     */
    public void saveCache(String idempotencyKey, String urlPath, String requestToCache, String responseToCache) {
        saveCache(idempotencyKey, "", "", urlPath, requestToCache, responseToCache);
    }

    /**
     * @param idempotentKey
     * @param requestMethod
     * @param urlPath
     * @param requestToCache
     * @param responseToCache
     */
    public void saveCache(String idempotencyKey, String requestMethod, String urlPath, String requestToCache,
                          String responseToCache) {
        saveCache(idempotencyKey, "", requestMethod, urlPath, requestToCache, responseToCache);
    }

    /**
     * @param idempotentKey
     * @param clientId
     * @param requestMethod
     * @param urlPath
     * @param requestToCache
     * @param responseToCache
     */
    public void saveCache(String idempotencyKey, String clientId, String requestMethod, String urlPath, String requestToCache,
                          String responseToCache) {

        IdempotencyRequest idrequest = new IdempotencyRequest();
        idrequest.setClientId(clientId);
        idrequest.setIdempotencyKey(idempotencyKey);
        idrequest.setRequestMethod(requestMethod);
        idrequest.setUrlPath(urlPath);
        idrequest.setRequestPayload(requestToCache);
        idrequest.setResponsePayload(responseToCache);

        try {
            // saving response to cache
            String idempotencyServiceResponse = this.restTemplate.postForObject(idempotencyServiceUrl, idrequest,
                    String.class);

        } catch (Exception e) {
            // No throw here. Don't break the logic, continue the flow even if Idempotency Service is down or fails
        }
    }
}