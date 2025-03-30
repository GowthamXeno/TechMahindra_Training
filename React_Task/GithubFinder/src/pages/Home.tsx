import React from "react";
import { useNavigate } from "react-router-dom";
import UserForm from "../components/UserForm";

const Home: React.FC = () => {
  const navigate = useNavigate();

  const fetchUser = async (username: string) => {
    navigate(`/profile/${username}`);
  };

  return (
    <div className="container text-center mt-5">
      <h1>Welcome to GitHub Finder</h1>
      <UserForm onSearch={fetchUser} />
    </div>
  );
};

export default Home;
