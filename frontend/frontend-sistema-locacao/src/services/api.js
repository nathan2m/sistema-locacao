import axios from 'axios';
const conection = require('./apiBase');

const api = axios.create({ 
    baseURL: `${conection.API}/api/rest`,
    headers: {
        "Content-type": "application/json"
      }
});

export default api;