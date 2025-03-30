import React, { useState } from "react";

interface UserFormProps {
  onSearch: (username: string) => void;
}

const UserForm: React.FC<UserFormProps> = ({ onSearch }) => {
  const [username, setUsername] = useState("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (username.trim() === "") return;
    onSearch(username);
  };

  return (
    <form onSubmit={handleSubmit} className="d-flex gap-2">
      <input
        type="text"
        className="form-control"
        placeholder="Enter GitHub username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <button type="submit" className="btn btn-primary">Search</button>
    </form>
  );
};

export default UserForm;
