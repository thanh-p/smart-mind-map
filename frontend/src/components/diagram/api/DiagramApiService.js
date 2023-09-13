import { apiClient } from "./ApiClient"

export const retrieveDiagramNodeApi = 
    (diagramId, nodeId) => apiClient.get(`/map/api/v1/diagrams/${diagramId}/nodes/${nodeId}`)