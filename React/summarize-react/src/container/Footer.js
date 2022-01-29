import React from 'react';
import { Link } from 'react-router-dom';
import './Footer.css';

const Footer = () => (
	<div className="footer">
		<div className="copyright">
			© Copyright by{' '}
			<Link
				to={{ pathname: 'https://github.com/younghwani' }}
				target="_blank"
				style={{ color: 'black' }}
			>
				Younghwani
			</Link>
		</div>
	</div>
);

export default Footer;
