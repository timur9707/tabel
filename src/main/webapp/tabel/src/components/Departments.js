import { Menu } from 'antd';
import React from "react";
import 'antd/dist/antd.css';


export default class Department extends React.Component {
    state = {
        collapsed: false,
        departmentId: 1,
    };

    render() {
        return (
        <div>
            <Menu
                defaultSelectedKeys={["1"]}
                mode="inline"
                inlineCollapsed={this.state.collapsed}
            >
            <Menu.Item key="1" departmentId={1} >IT-отдел</Menu.Item>
            <Menu.Item key="2" departmentId={2}>Бухгалтерия</Menu.Item>
            </Menu>
        </div>
        )
    }
}