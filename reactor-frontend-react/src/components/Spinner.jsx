import React from "react";

function Spinner() {
  return (
    <div id="spinnerDiv">
     <div>
        <div className="spinner-grow text-warning" role="status">
            <span className="visually-hidden">Loading...</span>
        </div>
        <div className="spinner-grow text-warning" role="status">
            <span className="visually-hidden">Loading...</span>
        </div>
        <div className="spinner-grow text-warning" role="status">
            <span className="visually-hidden">Loading...</span>
        </div>
     </div>
    </div>
  );
}

export default Spinner;
