import {React, useEffect, useState } from 'react';
import addQuest from '../../methods/addQuest';
import deleteQuestById from '../../methods/deleteQuestById';
import getUserQuestsById from '../../methods/getUserQuestsById';
import Navbar from '../../util/navbar.component';
import QuestCard from '../../util/questCard.component'

import './myquests.styles.css';

const MyQuestsPage = () => {
    const [quests, setQuests] = useState([])
    const userId = 1
    const [selectedQuest, setSelectedQuest] = useState()
    const [description, setDescription] = useState('')
    const [tokens, setTokens] = useState(0)
    const [badges, setBadges] = useState(0)
    const getAndSetQuests = async () => {
        const result = await getUserQuestsById(userId)
        setQuests(result)
    }
    const addSelectedQuest = async () => {
        await addQuest(description, badges, tokens, userId)
    }
    useEffect(() => {
        getAndSetQuests()

    }, [])
    return (
        <>
        <Navbar />
        <div className='main-grid'>

        <div className='main-div'>
                {quests.map(quest => <QuestCard
                key={quest.questId}
                quest={quest}
                owner={true}
                onclick={() => setSelectedQuest(quest.questId)}
                selected={selectedQuest === quest.questId}
                > </QuestCard>)}
                
            </div>
            <div className='secondary-div'>
            <input onChange={event => setDescription(event.target.value)} type="input" placeholder="Description..." required />
            <input onChange={event => setBadges(event.target.value)} type="input" placeholder="Reward (badges)..." required />
            <input onChange={event => setTokens(event.target.value)} type="input" placeholder="Reward (tokens)..." required />

                <button onClick={() => addSelectedQuest()}>create a new quest</button>

            </div>
        </div>
            
        </>
    )
}

export default MyQuestsPage;