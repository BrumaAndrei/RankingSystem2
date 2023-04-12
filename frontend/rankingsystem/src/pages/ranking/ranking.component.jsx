import {React, useEffect, useState } from 'react';
import addQuest from '../../methods/addQuest';
import deleteQuestById from '../../methods/deleteQuestById';
import getRanking from '../../methods/getRanking';
import getUserQuestsById from '../../methods/getUserQuestsById';
import Navbar from '../../util/navbar.component';
import QuestCard from '../../util/questCard.component'
import UserCard from '../../util/userCard.component';

import './ranking.styles.css';

const RankingPage = () => {
    const [users, setUsers] = useState([])
    const [criteria, setCriteria] = useState('badge')
    const [refresh, setRefresh] = useState(false)
    const getAndSetUsers = async () => {
        const result = await getRanking(criteria)
        setUsers(result)
    }
    const changeCriteria = async () => {
        if(criteria == 'badge')
            setCriteria('token')
        else
            setCriteria('badge')
        setRefresh(!refresh)
    }
    useEffect(() => {
        getAndSetUsers()

    }, [refresh])
    return (
        <>
        <Navbar />
        <div className='main-grid'>

        <div className='main-div'>
                {users.map(user => <UserCard
                key={user.id}
                user={user}
                > </UserCard>)}
                
        </div>
        <div className='secondary-div'>
             <button onClick={() => changeCriteria()}>Change criteria</button>
        </div>
        </div>
            
        </>
    )
}

export default RankingPage;