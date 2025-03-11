import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const Logs: React.FC = () => {
  const [logs, setLogs] = useState<any[]>([]);

  useEffect(() => {
    axios.get("http://localhost:4500/logs").then((res) => setLogs(res.data));
  }, []);

  return (
    <div className="container mt-5">
      <h2>Search Logs</h2>
      {logs.length === 0 ? <p>No logs yet.</p> : 
        logs.map((log, index) => (
          <div key={index} className="card p-3 my-2">
            <Link to={`/profile/${log.username}`} className="text-decoration-none">
              <h5>{log.username}</h5>
            </Link>
            <p>Time: {log.timestamp}</p>
          </div>
        ))}
    </div>
  );
};

export default Logs;
