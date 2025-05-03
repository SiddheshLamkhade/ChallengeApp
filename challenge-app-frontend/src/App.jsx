import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ChallengeList from './ChallengeList'
import axios from 'axios'
import AddChallenge from './AddChallenge'
import './index.css';  // Import global CSS
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [challenges, setChallenges] = useState([]);
  useEffect(()=>{fetchChallenges();},[]);
  const fetchChallenges= async()=>{
    try{
      const response=await axios.get('http://localhost:8080/challenges');
      setChallenges(response.data);
    }catch(error){
      console.log(error);
    }
  };


  const handleChallengeAdded=()=>{
    fetchChallenges();
  }

  return (
    <div className="container mt-5">
      <h1>Monthly Challenges</h1> 
      <AddChallenge onChallengeAdded={handleChallengeAdded}/>
      <ChallengeList challenges={challenges}/>   
    </div>
  )
}

export default App
