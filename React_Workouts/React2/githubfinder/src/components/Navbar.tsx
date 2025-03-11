import { AiFillGithub } from "react-icons/ai";
import React from "react";
import { Link } from "react-router-dom";

const Navbar: React.FC = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container">
        <Link className="navbar-brand d-flex align-items-center gap-2" to="/">
          <AiFillGithub size={30} />
          <span>GitHub Finder</span>
        </Link>
        <div className="navbar-nav ms-auto">
          <Link className="nav-link" to="/">Home</Link>
          <Link className="nav-link" to="/logs">Logs</Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
