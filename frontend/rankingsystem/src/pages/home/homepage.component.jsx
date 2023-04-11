import React from 'react';
import { Link } from 'react-router-dom';
import Navbar from '../../util/navbar.component';

import './homepage.styles.css';

const HomePage = () => {
    return (
        <>
        <Navbar />
            <div>
                Welcome home
            </div>
        </>
    )
}

export default HomePage;