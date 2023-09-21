import { apiClient } from "./ApiClient"


export const retrieveTopicApi = 
    () => apiClient.get(`/map/api/v1/topics`)

export const retrieveAllMapsFromTopicApi = 
    (topicId) => apiClient.get(`/map/api/v1/topics/${topicId}/maps`)

export const retrieveMapApi = 
    (mapId) => apiClient.get(`/map/api/v1/maps/${mapId}`)

export const retrieveNodeApi = 
    (nodeId) => apiClient.get(`/map/api/v1/nodes/${nodeId}`)