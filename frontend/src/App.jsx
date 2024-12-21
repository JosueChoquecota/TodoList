import React, { useEffect, useState } from "react";
import { fetchHello } from "./services/api";

const App = () => {
  const [message, setMessage] = useState("");

  useEffect(() => {
    const fetchData = async () => {
      try {
        const data = await fetchHello();
        setMessage(data);
      } catch (error) {
        console.error("Error al obtener datos:", error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <h1>React con Spring Boot</h1>
      <p>{message}</p>
    </div>
  );
};

export default App;
