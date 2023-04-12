import {React, useEffect, useState } from 'react';
import getAllAvailableQuestsForUser from '../../../methods/getAllAvailableQuestsForUser';
import addQuest from '../../../methods/addQuest';
import getUserQuestsById from '../../../methods/getUserQuestsById';
import Navbar from '../../../util/navbar.component';
import QuestCard from '../../../util/questCard.component'

import './startquest.styles.css';
import startQuest from '../../../methods/startQuest';

const StartQuestPage = () => {
    const [quests, setQuests] = useState([])
    const userId = 1
    const [selectedQuest, setSelectedQuest] = useState()
    const [description, setDescription] = useState('')
    const [tokens, setTokens] = useState(0)
    const [badges, setBadges] = useState(0)
    const getAndSetQuests = async () => {
        const result = await getAllAvailableQuestsForUser(userId)
        setQuests(result)
    }
    const startSelectedQuest = async () => {
        await startQuest(selectedQuest, userId)
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

                <button onClick={() => startSelectedQuest()}>start this quest</button>

            </div>
        </div>
            
        </>
    )
}

export default StartQuestPage;