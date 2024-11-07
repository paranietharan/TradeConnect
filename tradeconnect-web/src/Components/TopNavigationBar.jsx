import styles from './styles/TopNavigationBar.module.css';
import eCommerceLogo from '../assets/e-commerce-logo.png';
import { Link } from 'react-router-dom';

function TopNavigationBar() {
    return (
        <div className={styles.topNavigationBarContainer}>
            <div className={styles.logoContainer}>
                <img src={eCommerceLogo} alt='logo' />
            </div>

            <div className={styles.navLinksContainer}>
                <Link to='/'>Home</Link>
                <Link to='/contact'>Products</Link>
                <Link to='/about'>About</Link>
                <Link to='/login'>Login</Link>
            </div>

            <div className={styles.searchBarContainer}>
                <input type='text' placeholder='Search for products...' />
                <button>
                    <i class="bi bi-search"></i>
                </button>
            </div>

            <div className={styles.cartFavContainer}>
                <Link to='/cart'>Cart</Link>
                <Link to='/favorites'>Favorites</Link>
            </div>
        </div>
    )
}

export default TopNavigationBar;