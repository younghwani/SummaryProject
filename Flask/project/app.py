from flask import Flask, jsonify, request
from transformers import pipeline

app = Flask(__name__)

summarizer = pipeline('summarization')

@app.route('/')
def hello_world():
    return 'Hello World!'

@app.route('/test', methods=['GET'])
def test():
    text = "This is.... Test... Flask..."
    return text

@app.route('/summarize', methods=['GET'])
def predict():
    text = request.args.get("text")
    summary = summarizer(text, max_length=100, min_length=30, do_sample=False)
    return summary[0]['summary_text']


if __name__ == '__main__':
    app.run()
