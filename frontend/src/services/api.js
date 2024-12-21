import axios from "axios";

// URL del backend
const API_URL = "http://localhost:8080/api";

export const fetchHello = async () => {
  try {
    const response = await axios.get(`${API_URL}/hello`);
    return response.data;
  } catch (error) {
    console.error("Error al consumir el API:", error);
    throw error;
  }
};