import styles from './styles/TopNavBarProfile.module.css';
import { Link } from 'react-router-dom';
import { useState } from 'react';

function TopNavBarProfile() {
    const [isLoggedIn, setIsLoggedIn] = useState(true);
    const [dropdownVisible, setDropdownVisible] = useState(false);

    const toggleDropdown = () => {
        setDropdownVisible(!dropdownVisible);
    };

    return (
        <div className={styles.topNavBarProfileContainer}>
            <div
                className={`${styles.profileIcon} ${isLoggedIn ? styles.loggedIn : ''}`}
                onClick={toggleDropdown}
            >
                <i className="bi bi-person"></i>
            </div>
            {dropdownVisible && isLoggedIn && (
                <div className={styles.dropdownMenu}>
                    <Link to="/profile" className={styles.dropdownItem}>
                        <i class="bi bi-person"></i>
                        Manage My Account
                    </Link>
                    <Link to="/order" className={styles.dropdownItem}>
                        <i class="bi bi-basket3"></i>
                        My Order
                    </Link>
                    <Link to="/settings" className={styles.dropdownItem}>
                        <i class="bi bi-x-circle"></i>
                        My Cancellations
                    </Link>
                    <Link to="/settings" className={styles.dropdownItem}>
                        <i class="bi bi-star-fill"></i>
                        My Reviews
                    </Link>
                    <Link to="/logout" className={styles.dropdownItem}>
                        <i class="bi bi-box-arrow-left"></i>
                        Logout
                    </Link>
                </div>
            )}
        </div>
    )
}

export default TopNavBarProfile;