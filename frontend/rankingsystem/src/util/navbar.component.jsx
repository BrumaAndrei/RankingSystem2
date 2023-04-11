import React from 'react';
import { Link } from 'react-router-dom';

import './navbar.styles.css';
import User from '../assets/user.png';
import Logo from '../assets/check_mark.png';

const Navbar = () => {

    return (
        <div className='main-navbar-div'>
            <nav className="nav-menu">
                <Link to='/home' className='no-decoration'>
                <img className='navbar-logo' src={Logo} alt='Home' />
                </Link>
                <h3>Ranking System</h3>
                <div className="menu">
                        <Link to='/mystartedquests' className='no-decoration'>
                            <button class='button navbar-favs-button'>
                                My started quests
                            </button>
                        </Link>
                        <Link to='/myquests' className='no-decoration'>
                            <button class='button navbar-favs-button'>
                                My quests
                            </button>
                        </Link>
                        <Link to='/startquest' className='no-decoration'>
                            <button class='button navbar-favs-button'>
                                Start a new quest
                            </button>
                        </Link>
                        <Link to='/profile' className='no-decoration'>
                            <img className='navbar-logo' src={User} alt='User' />
                        </Link>
                </div>
            </nav>
        </div>
    )
}

export default Navbar;