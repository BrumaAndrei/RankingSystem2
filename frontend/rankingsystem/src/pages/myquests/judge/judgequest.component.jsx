import {React, useEffect, useState } from 'react';
import Navbar from '../../../util/navbar.component';
import QuestCard from '../../../util/questCard.component'

import './judgequest.styles.css';
import updateQuest from '../../../methods/updateQuest';
import getAllUserQuestsToJudge from '../../../methods/getAllUserQuestsToJudge';

const JudgeQuestPage = () => {
    const [quests, setQuests] = useState([])
    const userId = 1
    const [selectedQuest, setSelectedQuest] = useState()
    const getAndSetQuests = async () => {
        const result = await getAllUserQuestsToJudge(userId)
        setQuests(result)
    }
    const update = async () => {
        await updateQuest(selectedQuest, userId, true)
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

                <button onClick={() => update()}>set this quest as completed</button>

            </div>
        </div>
            
        </>
    )
}

export default JudgeQuestPage;