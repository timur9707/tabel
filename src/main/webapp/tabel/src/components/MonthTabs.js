import React from 'react';
import { Tabs } from 'antd';
import 'antd/dist/antd.css';
import Calendar from "./Calendar";
import axios from 'axios';

const {TabPane} = Tabs;
const month = ["January","February","March","April","May","June","July",
    "August","September","October","November","December"];

export default class MonthTab extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            daysList:[]
        }
        this.callback = this.callback.bind(this);
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/getMonthDays`, {
            params: {
                month: 1,
            }
        }).then(res => {
            this.setState({daysList: res.data});
        })
    }

    callback(key) {
        axios.get(`http://localhost:8080/getMonthDays`, {
            params: {
                month: month.indexOf(key) + 1,
            }
        }).then(res => {
            this.setState({daysList: res.data});
        })
    }

    render() {
        return (
            <div>
                <Tabs  defaultActiveKey="1" onChange={this.callback}>
                    {month.map(i => (
                        <TabPane  tab={i} key={i}>
                            <div>{i.toUpperCase()}</div>
                            <Calendar month = {month.indexOf(i)+1}
                                      daysList={this.state.daysList}
                                      departmentId={this.props.departmentId}
                            />
                        </TabPane>
                    ))}
                </Tabs>
            </div>
        )
    }
}