import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'

import C1Component from './C1Component.jsx'


createRoot(document.getElementById("root")).render(
  <StrictMode>
    <C1Component />
  </StrictMode>
);
