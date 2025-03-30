import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { toast } from "react-toastify";
import GitHubCalendar from "react-github-calendar";

const Profile: React.FC = () => {
  const { username } = useParams();
  const [userData, setUserData] = useState<any>(null);

  useEffect(() => {
    const fetchUser = async () => {
      try {
        const response = await axios.get(`https://api.github.com/users/${username}`);
        setUserData(response.data);

        await axios.post("http://localhost:4500/logs", {
          username,
          timestamp: new Date().toLocaleString(),
        });

        toast.success(`User ${username} loaded!`);
      } catch {
        toast.error("User not found!");
      }
    };
    fetchUser();
  }, [username]);

  if (!userData) return <h2 className="text-center mt-5">Loading...</h2>;

  return (
    <div className="container text-center mt-5">
      <img src={userData.avatar_url} alt="Profile" className="rounded-circle" width={150} />
      <h2>{userData.name || userData.login}</h2>
      <p>{userData.bio}</p>
      <p>Followers: {userData.followers} | Following: {userData.following}</p>

      {/* GitHub Calendar */}
      <h3 className="mt-4">GitHub Contributions</h3>
      <div style={{ display: "flex", justifyContent: "center" ,backgroundColor: "#b9fab9"}}>
        <GitHubCalendar username={username!} blockSize={10} blockMargin={5} colorScheme="light" />
      </div>
    </div>
  );
};

export default Profile;
