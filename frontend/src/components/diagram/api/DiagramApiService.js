import { apiClient } from "./ApiClient"

export const retrieveDiagramNodeApi = 
    (diagramId, nodeId) => apiClient.get(`/knowledge/api/v1/diagrams/${diagramId}/nodes/${nodeId}`)