import React from 'react';
import './App.css';
import MonthTab from "./components/MonthTabs";
import Department from "./components/Departments";

function App() {
  return (
    <div id="container">
        <div id="sidebar">
            <Department/>
        </div>
        <div id="content">
        <MonthTab/>
        </div>
    </div>
  );
}

export default App;
