import React, { useRef, useState, useEffect } from "react";
import ProductCard from './ProductCard';
import styles from './styles/RecomondationListBar.module.css';
import handBagImg from '../../assets/Product/6492.jpg';

export default function RecomondationListBar() {
    const scrollRef = useRef(null);
    const [activeIndex, setActiveIndex] = useState(0);

    const products = [
        { img: handBagImg, productName: "HandBag 1", price: 2000, offer: 20 },
        { img: handBagImg, productName: "HandBag 2", price: 2500, offer: 15 },
        { img: handBagImg, productName: "HandBag 3", price: 3000, offer: 10 },
        { img: handBagImg, productName: "HandBag 4", price: 3500, offer: 25 },
        { img: handBagImg, productName: "HandBag 5", price: 4000, offer: 30 },
        { img: handBagImg, productName: "HandBag 6", price: 4500, offer: 5 },
    ];

    const handleScroll = () => {
        const scrollLeft = scrollRef.current.scrollLeft;
        const cardWidth = scrollRef.current.offsetWidth;
        const newIndex = Math.round(scrollLeft / cardWidth);
        setActiveIndex(newIndex);
    };

    return (
        <div>
            <div
                className={styles.WishListBar}
                ref={scrollRef}
                onScroll={handleScroll}
            >
                {products.map((product, index) => (
                    <div key={index} className={styles.product}>
                        <ProductCard {...product} />
                    </div>
                ))}
            </div>
        </div>
    );
}