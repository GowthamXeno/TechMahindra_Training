import { v4 } from "uuid";

export default function UuidComponent() {
  const id = v4();
  return (
    <div>
      <h1>Your unique id is :</h1>
      <h2>{id}</h2>
      <h3>Refresh for new id</h3>
    </div>
  );
}
