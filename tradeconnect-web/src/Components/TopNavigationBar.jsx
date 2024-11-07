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
                <Link to='/'>Products</Link>
                <Link to='/'>About</Link>
                <Link to='/'>Login</Link>
            </div>

            <div className={styles.searchBarContainer}>
                <input type='text' placeholder='Search for products...' />
                <button>
                    <i class="bi bi-search"></i>
                </button>
            </div>

            <div className={styles.cartFavContainer}>
                <Link to='/cart' className={styles.cart}>
                    <i class="bi bi-cart2"></i>
                </Link>
                <Link to='/favorites' className={styles.fav}>
                    <i class="bi bi-heart"></i>
                </Link>
            </div>
        </div>
    )
}

export default TopNavigationBar;