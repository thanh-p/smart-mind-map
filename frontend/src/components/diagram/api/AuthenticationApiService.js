import { apiClient } from "./ApiClient"

export const executeJwtAuthenticationService 
    = (username, password) => apiClient.post(`/auth/api/v1/token`, {username, password})