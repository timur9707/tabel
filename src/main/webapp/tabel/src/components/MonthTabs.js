import React from 'react';
import { Tabs } from 'antd';
import 'antd/dist/antd.css';
import Calendar from "./Calendar";

const {TabPane} = Tabs;
const month = ["January","February","March","April","May","June","July",
    "August","September","October","November","December"];

export default class MonthTab extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Tabs  defaultActiveKey="1">
                    {month.map(i => (
                        <TabPane  tab={i} key={i}>
                            Current month: {i.toUpperCase()}
                            <Calendar month = {month.indexOf(i)+1}/>
                        </TabPane>
                    ))}
                </Tabs>
            </div>
        )
    }
}