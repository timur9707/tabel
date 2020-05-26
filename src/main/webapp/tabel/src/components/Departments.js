import { Menu } from 'antd';
import React from "react";
import 'antd/dist/antd.css';
import MonthTab from "./MonthTabs";

export default class Department extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            collapsed: false,
            departmentId:1,
        };
    }

    handleClick = e => {
        console.log('click ', e);
        this.setState({
            departmentId: e.key,
        })
    };

    render() {
        return (
        <div id="container">
            <div id="sidebar">
                <Menu
                    defaultSelectedKeys={"1"}
                    mode="inline"
                    inlineCollapsed={this.state.collapsed}
                >
                <Menu.Item key="1" onClick={this.handleClick}>IT-отдел</Menu.Item>
                <Menu.Item key="2"  onClick={this.handleClick} >Бухгалтерия</Menu.Item>
                </Menu>
            </div>
            <div id="content">
                <MonthTab departmentId={this.state.departmentId}/>
            </div>
        </div>
        )
    }
}