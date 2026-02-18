import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';
const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json'
  }
});

export const tasklistService = {
  getAll: () => api.get('/task-lists'),
  // getById: (id) => api.get(`/products/${id}`),
  // create: (data) => api.post('/products', data),
  // update: (id, data) => api.put(`/products/${id}`, data),
  // delete: (id) => api.delete(`/products/${id}`)
};

export default api;
