import React from "react";
import { Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import Profile from "./pages/Profile";
import Logs from "./pages/Logs";
import { ToastContainer } from "react-toastify";

const App: React.FC = () => {
  return (
    <>
      <Navbar />
      <ToastContainer position="top-right" autoClose={3000} />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/profile/:username" element={<Profile />} />
        <Route path="/logs" element={<Logs />} />
      </Routes>
    </>
  );
};

export default App;
