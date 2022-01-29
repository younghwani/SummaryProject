import axios from 'axios';
import React, { useState } from 'react';
import './Main.css';
import { Container, Form, FormGroup, Label, Button } from 'reactstrap';
import Footer from './Footer';
import Header from './Header';

const Main = () => {
	const [input, setInput] = useState('');
	const [isLoading, setIsLoading] = useState(false);
	const [isKor, setIsKor] = useState(true);

	let output = '';

	function onInputChange(event) {
		const target = event.target;
		const value = target.value;
		setInput(value);
		updateTextLen();
	}

	function updateTextLen() {
		console.log(input.length);
		document.querySelector(
			'.label__right'
		).textContent = `글자 수 : ${input.length}`;
	}

	const handleSubmitEn = async (event) => {
		event.preventDefault();
		setIsLoading(true);
		const data = await axios.get(
			`http://localhost:8080/api/summary?text=${input}`
		);
		output = data.data.output;
		console.log(output);
		setIsLoading(false);
		window.location.href = `/result/${output}`;
	};

	const handleSubmitKor = async (event) => {
		event.preventDefault();
		setIsLoading(true);
		const data = await axios.get(
			`http://localhost:8080/api/kobartSum?text=${input}`
		);
		output = data.data.output;
		console.log(output);
		setIsLoading(false);
		window.location.href = `/result/${output}`;
	};

	// TODO: 글자수가 일정 범위 이상이면 요약을 하지 못하도록 막도록 구성한다.
	// function handleKeyPress(target) {
	// 	if (target.charCode === 13) {
	// 		alert('Enter clicked!!!');
	// 	}
	// }

	function btnClickKo() {
		if (!isKor) {
			setInput('');
			document.getElementById('input').value = '';
		}
		setIsKor(true);
	}
	function btnClickEn() {
		if (isKor) {
			setInput('');
			document.getElementById('input').value = '';
		}
		setIsKor(false);
	}

	return (
		<div className="mainContainer">
			<video
				className="bg-video"
				playsInline
				autoPlay
				muted
				loop
				src="https://github.com/younghwani/temp/blob/master/sunrise.mp4?raw=true"
				typeof="video/mp4"
			></video>
			<div className="contentsContainer">
				<Header />
				{isLoading ? (
					<div className="runningMsg">
						<h2>요약 중입니다.</h2>
						<p>잠시 후 결과창으로 이동합니다.</p>
					</div>
				) : (
					<Container className="formContainer">
						<div className="btns">
							<button className="btn1" onClick={btnClickKo}>
								한글 요약
							</button>
							<button className="btn2" onClick={btnClickEn}>
								영어 요약
							</button>
						</div>
						<br />
						{isKor ? (
							<div>
								<Form onSubmit={handleSubmitKor}>
									<Label for="input" className="label">
										<div className="label__left">
											요약할 텍스트를 입력해주세요
											(한글만)!! 500자 이내로 입력하세요!
										</div>
										<div className="label__right">
											텍스트 길이가 표시됩니다.
										</div>
									</Label>
									<br />
									<textarea
										className="input__text"
										type="text"
										name="input"
										id="input"
										value={input}
										onChange={onInputChange}
										placeholder="한글 텍스트를 입력"
									/>
									<br />
									<br />
									<FormGroup className="resultBtn">
										<Button color="success" type="submit">
											요약하기
										</Button>{' '}
										<Button color="danger" href={`/`}>
											취소
										</Button>
									</FormGroup>
								</Form>
							</div>
						) : (
							<div>
								<Form onSubmit={handleSubmitEn}>
									<Label for="input">
										Input text (only english)!! Max length:
										500!
									</Label>
									<br />
									<textarea
										className="input__text"
										type="text"
										name="input"
										id="input"
										value={input}
										onChange={onInputChange}
										placeholder="Input text.."
									/>
									<br />
									<br />
									<FormGroup className="resultBtn">
										<Button color="success" type="submit">
											요약하기
										</Button>{' '}
										<Button color="danger" href={`/`}>
											취소
										</Button>
									</FormGroup>
								</Form>
							</div>
						)}
						<br />
						<br />
					</Container>
				)}
				<Footer />
			</div>
		</div>
	);
};

export default Main;
