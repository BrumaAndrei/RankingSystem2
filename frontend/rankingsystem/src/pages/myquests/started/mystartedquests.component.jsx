import {React, useEffect, useState } from 'react';
import getUserStartedQuestsById from '../../../methods/getUserStartedQuestsById';
import Navbar from '../../../util/navbar.component';
import QuestCard from '../../../util/questCard.component'

import './mystartedquests.styles.css'

const MyStartedQuestPage = () => {
    const [quests, setQuests] = useState([])
    const userId = 1;
    const getAndSetQuests = async () => {
        const result = await getUserStartedQuestsById(userId)
        setQuests(result)
    }
    useEffect(() => {
        getAndSetQuests()

    }, [])
    return (
        <>
        <Navbar />
            <div className='main-div'>
                {quests.map(quest => <QuestCard
                key={quest.questId}
                quest={quest}
                owner={false}
                > </QuestCard>)}
            </div>

        </>
    )
}

export default MyStartedQuestPage;