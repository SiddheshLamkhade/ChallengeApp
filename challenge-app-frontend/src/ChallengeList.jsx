import React from 'react'
import Challenge from './Challenge'
import './App.css';
import './index.css'
const ChallengeList = ({challenges}) => {
  return (
    <div>        
        {challenges.map(
            challenge=>(<Challenge key={challenge.id} challenge={challenge}/>)
        )}       
    </div>
  );
}

export default ChallengeList