import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const Challenge = ({ challenge }) => {
  return (
    <div className="card shadow-sm mb-2" style={{ width: '95%', height: 'auto' }}>
      <div className="card-body p-1"> {/* Further reduced padding */}
        {/* Month with a border below */}
        <h5 className="card-title mb-1 pb-1 border-bottom">{challenge.month}</h5> {/* Further reduced margin */}
        
        {/* Description */}
        <p className="card-text">{challenge.description}</p>
      </div>
    </div>
  );
};

export default Challenge;
