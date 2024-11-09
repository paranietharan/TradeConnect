import { Link } from 'react-router-dom';
import styles from './styles/Category.module.css';

function Category() {
  return (
    <div className={styles.CategoryContainer}>
      <Link to='/women-fashion'>Women Fashion</Link>
      <Link to="/mens-fashion">Men's Fashion</Link>
      <Link to="/electronics">Electronics</Link>
      <Link to="/home-and-lifestyle">Home and Lifestyle</Link>
      <Link to="/medicine">Medicine</Link>
      <Link to='/sports-and-outdoors'>Sports and Outdoors</Link>
      <Link to="/baby-and-toys">Baby and Toys</Link>
      <Link to='/groceries-and-pets'>Groceries and Pets</Link>
      <Link to="/health-and-beauty">Health and Beauty</Link>
    </div>
  );
}

export default Category;