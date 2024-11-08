import styles from '../Styles/TopNavBarProfile.module.css';

function TopNavBarProfile() {
    return (
        <div className={styles.topNavBarProfileContainer}>
            <Link to="/profile" className={styles.profile}>
                <i class="bi bi-person"></i>
            </Link>
        </div>
    )
}

export default TopNavBarProfile;